package mylittlemozart.factory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/**
 * A Factory class that applies legato styling to a note
 * Achieved by making the notes 80 ticks longer giving a smoother and more connected sound
 */
public class LegatoMidiEventFactory implements MidiEventFactory {
	
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
	    return new MidiEvent(message, tick + 80);
	}

}
