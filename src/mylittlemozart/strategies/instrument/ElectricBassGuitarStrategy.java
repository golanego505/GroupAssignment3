package mylittlemozart.strategies.instrument;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class ElectricBassGuitarStrategy implements InstrumentStrategy{
	@Override
	public void applyInstrument(Track track, int channel) {
		//Electric Bass Guitar is instrument # 33
		// setMessage(commandType, channel, data1 (e.g. note or instrument), data2 (e.g. velocity or 0))
		try {
			ShortMessage message = new ShortMessage();
			message.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 33, 0);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}

}
