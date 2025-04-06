package mylittlemozart.strategies.instrument;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

/**
 *  An Instrument Strategy that sets the instrument to Acoustic Grand Piano.
 */
public class AcousticGrandPianoStrategy implements InstrumentStrategy{

	 /**
     * Applies the acoustic grand piano instrument to the specified channel in the track.
     *
     * @param track The MIDI track to which the instrument should be applied.
     * @param channel The MIDI channel on which the piano will play.
     */
	@Override
	public void applyInstrument(Track track, int channel) {
		//Piano is instrument # 0
		// setMessage(commandType, channel, data1 (e.g. note or instrument), data2 (e.g. velocity or 0))
		try {
			ShortMessage message = new ShortMessage();
			message.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 0, 0);
			track.add(new MidiEvent(message, 0));
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}

}
