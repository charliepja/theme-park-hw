package behaviours;

import people.Visitor;

public interface ISecurity {
    Boolean isAllowedTo(Visitor visitor);
}
