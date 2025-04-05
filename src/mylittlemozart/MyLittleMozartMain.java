package mylittlemozart;

import java.util.List;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import mylittlemozart.factory.*;
//import mylittlemozart.factory.MidiEventFactoryAbstract;
//import mylittlemozart.factory.StandardMidiEventFactoryAbstract;
import mylittlemozart.parser.*;
import mylittlemozart.strategies.instrument.*;
import mylittlemozart.strategies.pitch.*;

public class MyLittleMozartMain {

	public static void main(String[] args) {
        try {
        	
            List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("src/files/mystery_song.csv");

            Sequence sequence = new Sequence(Sequence.PPQ, 384);
            Track track = sequence.createTrack();

            // Choose one of these factories
            MidiEventFactoryAbstract factoryAbstract = new StandardMidiEventFactoryAbstract();
            // factoryAbstract = new LegatoMidiEventFactoryAbstract();
            // factoryAbstract = new StaccatoMidiEventFactoryAbstract();

            MidiEventFactory factory = factoryAbstract.createFactory();

            // Choose and apply instrument strategies per channel
            InstrumentStrategy instrumentStrategy = new ElectricBassGuitarStrategy();
            instrumentStrategy.applyInstrument(track, 0);

            instrumentStrategy = new TrumpetStrategy();
            instrumentStrategy.applyInstrument(track, 1);

            // Choose a pitch strategy
            PitchStrategy pitchStrategy = new HigherPitchStrategy();

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

