package mylittlemozart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mylittlemozart.parser.*;

public class TestClass {
	
	/**
	 * Method tests if the midi Csv file has all valid lines and the # of objects in the list matches the # of lines in the file
	 * Checking for proper file parsing.
	 * 
	 * @return true if all lines in the file are valid and # of objects matches # of lines, false if not or file cannot be read.
	 */
	public static boolean testParse()
	{
		try 
		{
			List<MidiEventData> events = MidiCsvParser.parseCsv("mystery_song.csv");
			if(events.size() == MidiCsvParser.lineCount)
			{
				//Midi objects match each note in the file
				return true;
			}
			//Reading incorrect or incomplete lines in the midi file
			return false;
		}
		catch (IOException e)
		{
			System.out.println("Error reading file.");
			e.printStackTrace();
			return false;
		}
	}

}
