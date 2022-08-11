package yeling.spring.board.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@ToString(exclude = "member")
@Entity
@Table(name="MYBOARD")
public class Board {
	@Id
	@GeneratedValue
	private Long seq;
	private String title;
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date regDate = new Date();
	@Column(updatable = false)
	private Long cnt = 0L;
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID", nullable = false, updatable = false)
	private Member member;
	public void setMember(Member member) {
		this.member = member;
		member.getBoardList().add(this);
	}
}
