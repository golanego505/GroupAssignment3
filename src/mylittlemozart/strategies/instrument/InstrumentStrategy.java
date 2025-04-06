package mylittlemozart.strategies.instrument;

import javax.sound.midi.Track;

/**
 * A strategy interface for applying a specific instrument to a MIDI track and channel.
 */
public interface InstrumentStrategy {
	
	/**
	 * Applies the new instrument to the given MIDI track and channel.
	 * @param track The MIDI track to apply the instrument to.
	 * @param channel The MIDI channel on which the instrument should be set.
	 */
	void applyInstrument(Track track, int channel);
}
