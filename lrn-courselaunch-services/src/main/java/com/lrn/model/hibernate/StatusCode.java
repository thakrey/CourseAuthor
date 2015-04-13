package com.lrn.model.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The Class StatusCode.
 */
@Entity
@SequenceGenerator(
		name		 = "GEN_SEQ",
		sequenceName = "STATUS_CODE_SEQ"
)
@Table(name = "status_code")
public class StatusCode extends AbstractBaseEntity {

	public static final String ACTIVE 			= "active";

	public static final String DEACTIVATED 		= "deactivated";

	public static final String COMPLETE 		= "complete";

	public static final String INCOMPLETE 		= "incomplete";

	public static final String PUBLISHED 		= "Published";

	public static final String ASSIGNED 		= "Assigned";

	public static final String NEWRISKAREA 		= "New Risk Area";

	public static final String DRAFT 			= "Draft";

	public static final String CLOSE 			= "close";
	
	private static final long serialVersionUID = -4532344590540576637L;

	public static enum DEFAULTS{
		ACTIVE(StatusCode.ACTIVE),
		DEACTIVATED(StatusCode.DEACTIVATED),
		COMPLETE(StatusCode.COMPLETE),
		INCOMPLETE(StatusCode.INCOMPLETE),
		PUBLISHED(StatusCode.PUBLISHED),
		ASSIGNED(StatusCode.ASSIGNED),
		NEWRISKAREA(StatusCode.NEWRISKAREA),
		DRAFT(StatusCode.DRAFT),
		CLOSE(StatusCode.CLOSE);
		
		private final String name;
		
		DEFAULTS(String name){
			this.name = name;
		}
		
		public String getName(){ return name; }
	}
	
	//public static String[] DEFAULT_STATUS_CODES = {StatusCode.DEACTIVATED, StatusCode.ACTIVE};
	
	/** The name. */
	@Column(name = "NAME")
	private String name;

	/**
	 * Gets the name.
	 *
	 * @return the status name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 * 		 the status name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
