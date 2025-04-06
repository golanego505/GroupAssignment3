package mylittlemozart.factory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

public interface MidiEventFactory {
	/**
	 * Creates a NOTE_ON MidiEvent at the specified tick 
	 * @param tick		tick when the note starts
	 * @param note		midi note
	 * @param velocity	velocity of a note
	 * @param channel	midi channel
	 * @return			A MidiEvent with NOTE_ON message
	 * @throws InvalidMidiDataException		If MidiEvent fails to be created
	 */
	MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException;
	
	/**
	 * Creates a NOTE_OFF MidiEvent at a given tick 
	 * Adds standard, legato, and staccato styling to note
	 * Standard is the tick amount from CSV file
	 * Legato adds 80 ticks to the length of the note
	 * Staccato subtracts 120 ticks to the length of the note
	 * This is done by adding or subtracting from the tick parameter of MidiEvent
	 * @param tick		tick when note is stopped
	 * @param note		midi note
	 * @param channel	midi channel
	 * @return			A MidiEvent with NOTE_OFF message
	 * @throws InvalidMidiDataException		If MidiEvent fails to be created
	 */
	MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException;

	
}
