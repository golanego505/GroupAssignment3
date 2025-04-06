package mylittlemozart.factory;

/**
 * {@inheritDoc}
 */
public class StaccatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MidiEventFactory createFactory() {
		return new StaccatoMidiEventFactory();
	}

}
