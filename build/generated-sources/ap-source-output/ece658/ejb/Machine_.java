package ece658.ejb;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-11-15T21:39:22")
@StaticMetamodel(Machine.class)
public class Machine_ { 

    public static volatile SingularAttribute<Machine, Integer> id;
    public static volatile SingularAttribute<Machine, String> platform;
    public static volatile SingularAttribute<Machine, String> owner;
    public static volatile SingularAttribute<Machine, String> powerstate;

}