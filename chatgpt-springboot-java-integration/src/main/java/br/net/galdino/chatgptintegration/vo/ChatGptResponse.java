package br.net.galdino.chatgptintegration.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ChatGptResponse implements Serializable {

	private static final long serialVersionUID = -8255380953745929761L;
	
	public ChatGptResponse(List<Choice> choices) {
		this.choices = choices;
	}
	
	public ChatGptResponse() {}

	private List<Choice> choices;

	public List<Choice> getChoices() {
		return choices;
	}

	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}

	@Override
	public int hashCode() {
		return Objects.hash(choices);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChatGptResponse other = (ChatGptResponse) obj;
		return Objects.equals(choices, other.choices);
	}

	@Override
	public String toString() {
		return "ChatGptResponse [choices=" + choices + "]";
	}

}
