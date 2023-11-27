package br.net.galdino.chatgptintegration.vo;

import java.io.Serializable;
import java.util.Objects;

public class Choice implements Serializable {

	private static final long serialVersionUID = 8046143273419363257L;
	
	private int index;
	
	private Message message;
	
	public Choice(int index, Message message) {
		this.index = index;
		this.message = message;
	}
	
	public Choice() {}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		return Objects.hash(index, message);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Choice other = (Choice) obj;
		return index == other.index && Objects.equals(message, other.message);
	}

	@Override
	public String toString() {
		return "Choice [index=" + index + ", message=" + message + "]";
	}

}
