import org.sql2o.*;

public class Monster {
  private String name;
  private int personId;

  public Monster(String name, int personId) {
    this.name = name;
    this.personId = personId;
  }

public String getName() {
  return name;
}

public int getPersonId() {
  return personId;
}

@Override
  public boolean equals(Object otherMonster){
    if (!(otherMonster instanceof Monster)) {
      return false;
    } else {
      Monster newMonster = (Monster) otherMonster;
      return this.getName().equals(newMonster.getName()) &&
             this.getPersonId() == newMonster.getPersonId();
    }
  }

  public void save() {
      try(Connection con = DB.sql2o.open()) {
        String sql = "INSERT INTO monsters (name, personid) VALUES (:name, :personId)";
        this.id = (int) con.createQuery(sql, true)
          .addParameter("name", this.name)
          .addParameter("personId", this.personId)
          .executeUpdate()
          .getKey();
      }
    }
}
