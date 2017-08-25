package com.rockers.api.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.Hibernate;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 8747189793690340570L;

    public BaseEntity() {
    }
    
    public BaseEntity(final Long id) {
        this.id = id;
    }
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    
    @Override
    public int hashCode() {
        return getId() == null ? System.identityHashCode(this) : getId().hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        return this == obj || obj != null && Hibernate.getClass(obj).equals(getClass()) && ((BaseEntity) obj).getId().equals(getId());
    }

}
