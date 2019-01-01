package io.github.oliviercailloux.y2018;

import java.util.Optional;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Strings;

// 

@Entity
@JsonbPropertyOrder({ "id", "description", "compulsory", "periode", "master", "teacher", "contents" })
@XmlRootElement
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlAttribute
	private int id;

	@ManyToOne
	@JoinColumn(name = "idMaster")
	@XmlElement
	private Master master;

	@OneToMany
	@JoinColumn(name = "idContents")
	@XmlElement
	private Content contents;

	@OneToMany
	@JoinColumn(name = "idTeacher")
	@XmlElement
	private Person teacher;

	private String periode;

	private Optional<Boolean> compulsory;

	/**
	 * description correspond to note in db.
	 */
	private String description;

	private static Jsonb jsonb = JsonbBuilder.create();

	private CourseShort courseShort;

	public Course() {
		super();
		this.periode = "";
		this.compulsory = Optional.empty();
		this.description = "";
		this.courseShort = new CourseShort();
	}

	/**
	 * @param periode
	 * @param compulsory
	 * @param note
	 */
	public Course(String periode, boolean compulsory, String description) {
		super();
		this.periode = Strings.nullToEmpty(periode);
		this.compulsory = Optional.of(compulsory);
		this.description = Strings.nullToEmpty(description);
		this.courseShort = new CourseShort(periode, compulsory, description);
	}

	/**
	 * @param periode
	 * @param compulsory
	 * @param note
	 */
	public Course(int id, String periode, boolean compulsory, String description) {
		super();
		this.id = id;
		this.periode = Strings.nullToEmpty(periode);
		this.compulsory = Optional.of(compulsory);
		this.description = Strings.nullToEmpty(description);
	}

	public Master getIdMaster() {
		return master;
	}

	public int getId() {
		return id;
	}

	public Content getContents() {
		return contents;
	}

	public Person getTeacher() {
		return teacher;
	}

	/**
	 * @return not null.
	 */
	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		periode = Strings.nullToEmpty(periode);
	}

	public Optional<Boolean> getCompulsory() {
		return compulsory;
	}

	public void setCompulsory(boolean compulsory) {
		this.compulsory = Optional.of(compulsory);
	}

	/**
	 * 
	 * @return not null
	 */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = Strings.nullToEmpty(description);
	}

	public CourseShort getCourseShort() {
		return courseShort;
	}

	public void setCourseShort(CourseShort courseShort) {
		this.courseShort = courseShort;
	}

	/**
	 * @return Cours not null
	 */
	public String toJson() {
		return jsonb.toJson(this);
	}

	public String toShortJson() {
		return jsonb.toJson(this.getCourseShort());
	}

	/**
	 * @param jsonCours is not null nor empty
	 * @return Object : Cours not null
	 * 
	 */
	public static Course fromJson(String jsonbCours) throws IllegalArgumentException, NullPointerException {
		if (jsonbCours == null || jsonbCours.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return jsonb.fromJson(jsonbCours, Course.class);
	}
}
