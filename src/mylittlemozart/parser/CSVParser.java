package mylittlemozart.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.sound.midi.*;

public class CSVParser {
	
	public static List<MidiEventData> parseCsv(String filepath) throws IOException
	{
		List<MidiEventData> midiEvents = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(filepath));
		String line;
		int noteOnOff;
		//startEndTick(0), Note on off(1), channel(2), note(3), velocity(4) , instrument(5)
		
		int count = 0; //debug var, count # of lines in the csv file
		while((line = reader.readLine()) != null)
		{
			String[] parts = line.trim().split(",");
			if(parts.length != 6)
			{
				continue; 
			}
			
			int startEndTick = Integer.parseInt(parts[0].trim());
			String noteOnOffStr = parts[1];
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
			count++;
		}
		
		System.out.println("Number of lines in CSV file: " + count); //debug code
		reader.close();
		return midiEvents;
	}
	
	

}
