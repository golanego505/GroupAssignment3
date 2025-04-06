package mylittlemozart.strategies.instrument;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

/**
 * An InstrumentStrategy that sets the instrument to Electric Bass
 */
public class ElectricBassGuitarStrategy implements InstrumentStrategy{
	
	/**
	 *  Applies the electric bass guitar instrument to the specified channel in the track.
     *
     * @param track The MIDI track to which the instrument should be applied.
     * @param channel The MIDI channel (0–15) on which the electric bass will play.
	 */
	@Override
	public void applyInstrument(Track track, int channel) {
		//Electric Bass Guitar is instrument # 33
		// setMessage(commandType, channel, data1 (e.g. note or instrument), data2 (e.g. velocity or 0))
		try {
			ShortMessage message = new ShortMessage();
			message.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 33, 0);
			track.add(new MidiEvent(message, 0));
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}

}
