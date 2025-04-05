package mylittlemozart.strategies.instrument;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class AcousticGrandPianoStrategy implements InstrumentStrategy{

	@Override
	public void applyInstrument(Track track, int channel) {
		//Piano is instrument # 0
		// setMessage(commandType, channel, data1 (e.g. note or instrument), data2 (e.g. velocity or 0))
		try {
			ShortMessage message = new ShortMessage();
			message.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 0, 0);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}

}
