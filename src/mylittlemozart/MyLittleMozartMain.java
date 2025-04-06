package mylittlemozart;

import java.util.List;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import mylittlemozart.factory.*;
import mylittlemozart.parser.*;
import mylittlemozart.strategies.instrument.*;
import mylittlemozart.strategies.pitch.*;

public class MyLittleMozartMain {

	/**
	 * The main entry point for the Group Assignment 3 application.
	 * 
	 * This method reads a MIDI-formatted CSV file, applies a type of factory to create specific sounds, and applies pitch and instrument
	 * strategies.
	 * The method then uses the Java's built in MIDI sequence to generate and play a MIDI sequence.
	 */
	public static void main(String[] args) {
        try {
        	
            List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("./files/mystery_song.csv");

            Sequence sequence = new Sequence(Sequence.PPQ, 384);
            Track track = sequence.createTrack();

            // Choose one of these factories
            MidiEventFactoryAbstract factoryAbstract; 
            factoryAbstract = new StandardMidiEventFactoryAbstract();
            //factoryAbstract = new LegatoMidiEventFactoryAbstract();
            //factoryAbstract = new StaccatoMidiEventFactoryAbstract();

            MidiEventFactory factory = factoryAbstract.createFactory();

            // Choose and apply instrument strategies per channel
            InstrumentStrategy instrumentStrategy = new ElectricBassGuitarStrategy();
            instrumentStrategy.applyInstrument(track, 0);

            instrumentStrategy = new TrumpetStrategy();
            instrumentStrategy.applyInstrument(track, 1);

            // Choose a pitch strategy
            PitchStrategy pitchStrategy = new HigherPitchStrategy();
            pitchStrategy = new LowerPitchStrategy();

            for (MidiEventData event : midiEvents) {
                int modifiedNote = pitchStrategy.modifyPitch(event.getNote());
                modifiedNote = pitchStrategy.modifyPitch(modifiedNote); // apply again if desired

                if (event.getNoteOnOff() == ShortMessage.NOTE_ON) {
                    track.add(factory.createNoteOn(event.getStartEndTick(),
                            modifiedNote,
                            event.getVelocity(),
                            event.getChannel()
                    ));
                } else {
                    track.add(factory.createNoteOff(event.getStartEndTick(), modifiedNote, event.getChannel()));
                }
            }

            // Play the sequence
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.setSequence(sequence);
            sequencer.start();

            while (sequencer.isRunning() || sequencer.isOpen()) {
                Thread.sleep(100);
            }

            Thread.sleep(500);
            sequencer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	// Testing case from TestClass
	//	boolean testResult;
	//	
	//	testResult = TestClass.testParse();
	//	
	//	if(testResult)
	//	{
	//		System.out.println("File Parsed Successfully.");
	//	}
	//	else
	//	{
	//		System.out.println("Test Failed.");
	//	}
	//	System.out.println("Tests finished...");
}

