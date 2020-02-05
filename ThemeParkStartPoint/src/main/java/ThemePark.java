import attractions.*;
import behaviours.IReviewed;
import stalls.*;

import java.util.ArrayList;

public class ThemePark {
    private ArrayList<IReviewed> reviewedAttractions;

    public ArrayList<IReviewed> getAllReviewed() {
        return reviewedAttractions;
    }
}
