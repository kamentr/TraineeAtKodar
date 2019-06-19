package net.kodar.trainee.dataaccess.dao.discipline.data;

import net.kodar.trainee.data.entities.Discipline;

import java.util.HashMap;
import java.util.Map;

public class DisciplineData {

    public static  Map<Integer, Discipline> disciplineMapData = new HashMap<>();

    public DisciplineData(){
        disciplineMapData.put(1, new Discipline(1,"Maths"));
        disciplineMapData.put(2, new Discipline(2,"English"));
        disciplineMapData.put(3, new Discipline(3,"Sports"));
        disciplineMapData.put(4, new Discipline(4,"Informatics"));
    }
}
