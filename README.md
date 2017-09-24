[logo]: SchematBazy.png "Schemat bazy danych"

# Założenia projektu

Stworzyć  prostą aplikację która będzie umożliwiała zarządzanie ligą. 

- Aplikacja pozwoli na wyświetlenie oraz stworzenie i alktualizacje drużyny
- Aplikacja pozwoli na wyświetlenie oraz dodanie  zawodnika do drużyny i alktualizacje 
- Aplikacja pozwoli na wyświetlenie oraz dodanie meczów do drużyn
- Aplikacja pozwoli na wyświetlenie oraz dodanie goli do meczów i zawodnikó

# Schemat bazy danych
![alt text][logo]

# Encje

### Team
```java
@Entity
@Table(name = "team")
@XmlRootElement
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@XmlAttribute
	int id;
	@Column(name = "name")
	String name;
	@Column(name = "city")
	String city;
	@Column(name = "league")
	String league;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "team", orphanRemoval = true)
	@JsonManagedReference(value="footballers")
	Set<Footballer> footballers = new LinkedHashSet<Footballer>();
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "team", orphanRemoval = true)
	Set<Match> matches = new LinkedHashSet<Match>();
	
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getCity(){
		return city;
	}
	
	public void setCity(String city){
		this.city = city;
	}
	
	
	public String getLeague(){
		return league;
	}
	
	public void setLeague(String leageu){
		this.league = leageu;
	}
	
	public Collection<Footballer> getFootballers(){
		return footballers;
	}
	
	public void setFootballers(Set<Footballer> footballers){
		this.footballers = footballers;				
	}
	
	public Collection<Match> getMatches(){
		return matches;
	}
	
	public void setMatches(Set<Match> matches){
		this.matches = matches;
	}
}
```

### Footballer
```java
@Entity
@Table(name = "footballer")
@XmlRootElement
public class Footballer implements Serializable{
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlAttribute
	int id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "surname")
	String surname;
	
	@Column(name = "age")
	int age;
	
	@Column(name = "number")
	int number;
	
	@ManyToOne
	@JoinColumn(name = "teamId")
	@JsonBackReference(value = "footballers")
	Team team;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "footballer", orphanRemoval = true)
	@JsonManagedReference(value = "goals")
	Set<Goal> goals = new LinkedHashSet<Goal>();
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public Collection<Goal> getGoals(){
		return goals;
	}
	
	public void setGoals(Set<Goal> goals){
		this.goals = goals;
	}
	
	public void setTeam(Team team){
		this.team = team;
	}
	
	public Team getTeam(){
		return this.team;
	}
}
```

### Match
```java
@Entity
@Table(name = "match")
@XmlRootElement
public class Match implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@XmlAttribute
	int id;
	@Column(name = "date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") 
	LocalDate date;
	@Column(name = "time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm")
	LocalTime time;
	@Column(name = "city")
	String city;
	
	@JsonInclude(Include.NON_NULL)
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "match", orphanRemoval = true)
	@JsonManagedReference(value="match")
	Set<Goal> goals = new HashSet<Goal>();
	
	@ManyToOne
	@JoinColumn(name = "HostId")
	@JsonBackReference(value = "HostId")
	Team host;
	
	@ManyToOne
	@JoinColumn(name = "GuestId")
	@JsonBackReference(value = "GuestId")
	Team guest;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	
	public LocalDate getDate(){
		return date;
	}
	
	public void setDate(LocalDate date){
		this.date = date;
	}
	
	public void setDate(String date){
		this.date = LocalDate.parse(date);
	}
	
	
	
	public LocalTime getTime(){
		return time;
	}
	
	public void setTime(LocalTime time){
		this.time = time;
	}
	
	public void setTime(String time){
		this.time = LocalTime.parse(time);
	}

	public Team getHostTeam() {
		return host;
	}
	
	public void setHostTeam(Team host){
		this.host = host;
	}

	public Team getGuestTeam() {
		return guest;
	}
	
	public void setGuestTeam(Team guest){
		this.guest = guest;
	}
	
	public String getCity(){
		return city;
	}
	
	public void setCity(String city){
		this.city = city;
	}
	
	public Collection<Goal> getGoals(){
		return goals;
	}
	
	public void setGoals(Set<Goal> goals){
		this.goals = goals;
	}

}
```

### Goal
```java
@Entity
@Table(name = "goal")
@XmlRootElement
public class Goal implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column(name = "time")
	LocalTime time;
	
	@Column(name = "teamName")
	String teamName;
	
	@ManyToOne
	@JoinColumn(name = "footballerId")
	@JsonBackReference(value = "goals")
	Footballer footballer;
	
	@ManyToOne(targetEntity=Match.class)
	@JoinColumn(name = "matchId")
	@JsonBackReference(value = "match")
	Match match;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public Footballer getFootballer() {
		return footballer;
	}
	
	public void setFootballer(Footballer footballer){
		this.footballer = footballer;
	}
	
	public Match getMatch() {
		return match;
	}
	
	public void setMatch(Match match){
		this.match = match;
	}
	
	
	public LocalTime getTime(){
		return time;
	}
	
	public void setTime(LocalTime time){
		this.time = time;
	}
	
	public void setTime(String time){
		this.time = LocalTime.parse(time);
	}
	
	
	public String getTeamName(){
		return teamName;
	}
	
	public void setTeamName(String teamName){
		this.teamName = teamName;
	}
}
```