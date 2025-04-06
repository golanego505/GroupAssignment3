package mylittlemozart.factory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/**
 * Factory class that produces standard note events
 * Uses default values given from CSV for timing and duration of notes
 */
public class StandardMidiEventFactory implements MidiEventFactory {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		 ShortMessage message = new ShortMessage();
		 message.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		 return new MidiEvent(message, tick);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
	    message.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
	    return new MidiEvent(message, tick);
	}

}
