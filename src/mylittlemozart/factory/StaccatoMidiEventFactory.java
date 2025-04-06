package mylittlemozart.factory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;


/**
 * Factory class that produces staccato note events
 * Achieved by subtracting 120 ticks to the duration of a note
 */
public class StaccatoMidiEventFactory implements MidiEventFactory {

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
		 return new MidiEvent(message, tick - 120);
	}

}
