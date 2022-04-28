package test.mypac;

public class Genie implements Remocon {

	@Override
	public void up() {
		System.out.println("지니야 채널 올려줘");
	}

	@Override
	public void down() {
		System.out.println("지니야 채널 내려줘");
	}

}
