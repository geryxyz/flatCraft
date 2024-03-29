package flatcraft;

public class Sheep extends Player {
	
	public Sheep() {
		super("");
		image = Images.SHEEP_RIGHT;
		canUseLadder = false;
	}
	
	public void startPatrol() {
		final Sheep sheep = this;
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					while(sheep.act(Action.MOVE_RIGHT, true, false)) {}
					while(sheep.act(Action.MOVE_LEFT, true, false)) {}
				}	
			}
			
		});
		thread.run();
	}

	@Override
	protected boolean act(Action action, boolean wait, boolean showError) {
		switch(action) {
			case MOVE_RIGHT:
			case JUMP_RIGHT:
			case JUMP_LONG_RIGHT:
				image = Images.SHEEP_RIGHT;
				break;
			case MOVE_LEFT:
			case JUMP_LEFT:
			case JUMP_LONG_LEFT:
				image = Images.SHEEP_LEFT;
				break;
			default:
				break;
		}
		
		return super.act(action, wait, showError);
	}
	
}
