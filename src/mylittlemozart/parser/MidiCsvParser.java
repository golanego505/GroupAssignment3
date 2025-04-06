package mylittlemozart.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.sound.midi.*;
/**
 * A Utility class used for parsing through Midi event formatted CSV files.
 * Uses static variables and methods.
 */
public class MidiCsvParser {
	
	/**
	 * Used for debugging. Counts the number of lines in the file
	 */
	public static int lineCount = 0;
	
	/**
	 * Parses through a CSV file and creates new MidiEventData objects from each line in the file.
	 * The method then populates a list of MidiEventData objects representing MIDI events
	 * Also increments the lineCount static variable on each successfully parsed line. 
	 * 
	 * The expected format of the file is:
	 * startEndTick, Note_on_c/Note_off_c, channel, note, velocity, instrument
	 * 
	 * Lines that do not match the expected format are skipped.
	 * 
	 * @param filepath the relative or absolute path to the CSV file
	 * @return a list of MidiEventData objects
	 * @throws IOException
	 * 
	 * @see MidiEventData
	 */
	public static List<MidiEventData> parseCsv(String filepath) throws IOException
	{
		List<MidiEventData> midiEvents = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(filepath));
		String line;
		int noteOnOff;
		
		//startEndTick(0), Note on off(1), channel(2), note(3), velocity(4) , instrument(5)
		while((line = reader.readLine()) != null)
		{
			String[] parts = line.trim().split(",");
			if(parts.length != 6)
			{
				continue; 
			}
			
			int startEndTick = Integer.parseInt(parts[0].trim());
			String noteOnOffStr = parts[1].trim();
			int channel = Integer.parseInt(parts[2].trim());
			int note = Integer.parseInt(parts[3].trim());
			int velocity = Integer.parseInt(parts[4].trim());
			int instrument = Integer.parseInt(parts[5].trim());
			
			
			if(noteOnOffStr.equalsIgnoreCase("Note_on_c")) 
			{
				noteOnOff = ShortMessage.NOTE_ON;
			}
			else
			{
				noteOnOff = ShortMessage.NOTE_OFF;
			}
			
			midiEvents.add(new MidiEventData(startEndTick, velocity, note, channel, instrument, noteOnOff));
			lineCount++;
		}
		
		//System.out.println("Number of lines in CSV file: " + count); //debug code
		reader.close();
		return midiEvents;
	}
	
	

}
