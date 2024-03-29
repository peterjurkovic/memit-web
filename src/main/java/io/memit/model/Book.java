package io.memit.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.memit.utils.DateTimeUtils;

@Entity
@Table(name = "m_book")
@SequenceGenerator(name = "m_book_id_seq", sequenceName = "m_book_id_seq", allocationSize = 1)
public class Book extends SynchronizableEntity {

	private String name;
	private Lang questionLang;
	private Lang answerLang;
	private User author;
	private Level level;
	private boolean published;
	
	private OffsetDateTime created;
	private Book forkedForm;
	private short downloaded;
	
	public Book() {
		super();
		setChanged(DateTimeUtils.localNow());
	}
	
	@Id
	@Override
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_book_id_seq")
	public Long getId() {
		return super.getId();
	}
	
	@Column(name = "book_name", nullable = false, length = 120)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "lang_question", length = 2)
	public Lang getQuestionLang() {
		return questionLang;
	}

	public void setQuestionLang(Lang questionLang) {
		this.questionLang = questionLang;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "lang_answer", length = 2)
	public Lang getAnswerLang() {
		return answerLang;
	}

	public void setAnswerLang(Lang answerLang) {
		this.answerLang = answerLang;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
	
	@Column(name = "is_published", nullable = false)
	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "level", length = 2)
	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	@Column(nullable = false)
	public OffsetDateTime getCreated() {
		return created;
	}

	public void setCreated(OffsetDateTime created) {
		this.created = created;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "forked_book_id")
	public Book getForkedForm() {
		return forkedForm;
	}

	public void setForkedForm(Book forkedForm) {
		this.forkedForm = forkedForm;
	}
	
	@Column(nullable = false)
	public short getDownloaded() {
		return downloaded;
	}

	public void setDownloaded(short downloaded) {
		this.downloaded = downloaded;
	}
	
	

}
