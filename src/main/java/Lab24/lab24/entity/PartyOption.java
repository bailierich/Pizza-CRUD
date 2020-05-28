package Lab24.lab24.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;




@Entity
public class PartyOption {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Integer votes;
	
	@ManyToOne
	private Party party;
	
	public Party getParty() {
		return party;
	}
	public void setParty(Party party) {
		this.party = party;
	}
	public PartyOption() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getVotes() {
		return votes;
	}
	public void setVotes(Integer votes) {
		this.votes = votes;
	}
}
