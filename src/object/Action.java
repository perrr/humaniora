package object;

public class Action {

	private Human human;
	private Object object;
	
	public Action(Human human, Object object) {
		this.human = human;
		this.object = object;
	}

	public Human getHuman() {
		return human;
	}

	public void setHuman(Human human) {
		this.human = human;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
}
