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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm") 
	Date date;
	
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
	
	
	public Date getDate(){
		return date;
	}
	
	public void setDate(String dateString) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		this.date = format.parse(dateString);
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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm") 
	Date time;
	
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
	
	
	public Date getTime(){
		return time;
	}
	
	public void setTime(String time) throws ParseException{
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		this.time = format.parse(time);
	}
	
	public String getTeamName(){
		return teamName;
	}
	
	public void setTeamName(String teamName){
		this.teamName = teamName;
	}
}
```

# Kontrolery

### Akcje kontrolerów
* `POST` - Tworzenie i zapis nowego obiektu danej encji	
* `PUT` - Uaktualnienie danej encji
* `GET` - pobranie z serwera encji na podstawie jej Id lub kolekcji encji zapisanych w bazie

### Team
#### ITeamController
```java
@Local
public interface ITeamsController {
	public abstract Response create(Team team);
	public abstract Response update(int id, Team team);
	public abstract Team getById(int id);
	public abstract Collection<Team> getList();
}

```

#### TeamController
```java
@Path("/teams")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class TeamsController implements ITeamsController {

	@EJB
	TeamRepository repository;
	
	@Override
	@POST
	@Path("/")
	public Response create(Team team) {
		repository.create(team);
		return Response.status(Status.CREATED).entity(team).build();
	}

	@Override
	@PUT
	@Path("/{id}")
	public Response update(@PathParam("id") int id, Team team) {
		try {
			team.setId(id);
			repository.update(team);
			return Response.status(Status.OK).build();
		}
		catch(Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@Override
	@GET
	@Path("/{id}")
	public Team getById(@PathParam("id") int id) {
		return repository.getTeamById(id);
	}

	@Override
	@GET
	@Path("/")
	public Collection<Team> getList() {
		Collection<Team> teams = repository.getList();
		return teams;
	}

}
```

#### Create
##### Request
* `POST`

```
{
	"name": string,
	"city": string,
	"league": string
}
```
##### Response
* `201`
<br>

#### Update
##### Request
* `PUT`

```
{
	"name": string,
	"city": string,
	"league": string
}
```
##### Response
* `200`
<br>

#### GetById
##### Request
* `GET`
	* `id`

##### Response
* `200`
```
{
	"id": int,
	"name": string,
	"city": string,
	"league": string,
	"footballers": [
		{
			"id": int,
			"name": string,
			"surname": string,
			"age": int,
			"number": int,
			"goals": []
		}
	],
	"matches": []
}
```

#### GetList
##### Request
* `GET`

##### Response
`200`
```
[
    {
		"id": int,
		"name": string,
		"city": string,
		"league": string,
		"footballers": [
			{
				"id": int,
				"name": string,
				"surname": string,
				"age": int,
				"number": int,
				"goals": []
			}
		],
		"matches": []
	}
]
```

### Footballer
#### IFootballersController
```java
@Local
public interface IFootballersController {
	public abstract Response create(Footballer footballer);
	public abstract Response update(int id, Footballer footballer);
	public abstract Footballer getById(int id);
	public abstract FootballersListResponse getList();
}
```
#### FootballerController
```java
@Path("/footballers")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class FootballersController implements IFootballersController {
	
	@EJB
	FootballerRepository repository;
	
	@Override
	@POST
	@Path("/")
	public Response create(Footballer footballer) {
		repository.create(footballer);
		return Response.status(Status.CREATED).entity(footballer.getId()).build();
	}

	@Override
	@PUT
	@Path("/{id}")
	public Response update(@PathParam("id") int id, Footballer footballer) {
		try {
			footballer.setId(id);
			repository.update(footballer);
			return Response.status(Status.OK).build();
		}
		catch(Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}
	
	@Override
	@GET
	@Path("/{id}")
	public Footballer getById(@PathParam("id") int id) {
		Footballer footballer = repository.getFootballerById(id);
		return footballer;
	}

	@Override
	@GET
	@Path("/")
	public FootballersListResponse getList() {
		List<Footballer> listOfFootballers = repository.getList();
		FootballersListResponse footballers = new FootballersListResponse(listOfFootballers);
		return footballers;
	}
}
```
#### Create
##### Request
* `POST`

```
{
	"name": string,
	"surname": string,
	"age": int,
	"number": int,
	"team": {
	    "id": int,
	    "name": string,
	    "city": string,
	    "league": string
	}
}
```
##### Response
* `201`
<br>

#### Update
##### Request
* `PUT`
```
{
	"name": string,
	"surname": string,
	"age": int,
	"number": int,
	"team": {
	    "id": int,
	    "name": string,
	    "city": string,
	    "league": string
	}
}
```
##### Response
* `200`
<br>

#### GetById
##### Request
* `GET`
	* `id`

##### Response
* `200`
```
{
	"id": int,
	"name": string,
	"surname": string,
	"age": int,
	"number": int,
	"goals": []
}
```
<br>

#### GetList
##### Request
* `GET`

##### Response
`200`
```
{
    "footballers": [
        {
            "id": int,
            "name": string,
            "surname": string,
            "age": int,
            "number": int,
            "goals": []
        }
    ]
}
```

### Match
#### IMatchController
```java
@Local
public interface IMatchesController {
	public abstract Response create(Match match);
	public abstract Response update(int id, Match match);
	public abstract Match getById(int id);
	public abstract MatchesListResponse getList();
}
```
#### MatchController
```java
@Path("/matches")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class MatchesController implements IMatchesController {

	@EJB
	MatchRepository repository;
	
	@Override
	@POST
	@Path("/")
	public Response create(Match match) {
		repository.create(match);
		return Response.status(Status.CREATED).entity(match.getId()).build();
	}

	@Override
	@PUT
	@Path("/{id}")
	public Response update(@PathParam("id") int id, Match match) {
		try {
			match.setId(id);
			repository.update(match);
			return Response.status(Status.OK).build();
		}
		catch(Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@Override
	@GET
	@Path("/{id}")
	public Match getById(@PathParam("id") int id) {
		return repository.getMatchById(id);
	}

	@Override
	@GET
	@Path("/")
	public MatchesListResponse getList() {
		List<Match> matches = repository.getList();
		return new MatchesListResponse(matches);
	}
}
```

#### Create
##### Request
* `POST`

```
{
	"date": string,
	"city": string,
	"hostTeam": {
		"id": int,
	    "name": string,
	    "city": string,
	    "league": string
	},
	"guestTeam": {
		"id": int,
	    "name": string,
	    "city": string,
	    "league": string
	}
}
```
##### Response
* `201`
<br>

#### Update
##### Request
* `PUT`
```
{
	"date": string,
	"city": string,
	"hostTeam": {
		"id": int,
	    "name": string,
	    "city": string,
	    "league": string
	},
	"guestTeam": {
		"id": int,
	    "name": string,
	    "city": string,
	    "league": string
	}
}
```
##### Response
* `200`
<br>

#### GetById
##### Request
* `GET`
	* `id`

##### Response
* `200`
```
{
	"id": int,
	"date": string,
	"city": string,
	"goals": [],
	"hostTeam": {
		"id": int,
		"name": string,
		"city": string,
		"league": string,
		"footballers": [
			{
				"id": int,
				"name": string,
				"surname": string,
				"age": int,
				"number": int,
				"goals": []
			}
		],
		"matches": []
	},
	"guestTeam": {
		"id": int,
		"name": string,
		"city": string,
		"league": string,
		"footballers": [
			{
				"id": int,
				"name": string,
				"surname": string,
				"age": int,
				"number": int,
				"goals": []
			}
		],
		"matches": []
	}
}
```
<br>

#### GetList
##### Request
* `GET`

##### Response
`200`
```
{
    "matches": [
        {
            "id": int,
            "date": string,
            "city": string,
            "goals": [],
            "hostTeam": {
                "id": int,
                "name": string,
                "city": string,
                "league": string,
                "footballers": [
                    {
						"id": int,
						"name": string,
						"surname": string,
						"age": int,
						"number": int,
						"goals": []
					}
                ],
                "matches": []
            },
            "guestTeam": {
                "id": int,
                "name": string,
                "city": string,
                "league": string,
                "footballers": [
                    {
						"id": int,
						"name": string,
						"surname": string,
						"age": int,
						"number": int,
						"goals": []
					}
                ],
                "matches": []
            }
        }
    ]
}
```

### Goal
#### IGoalsController
```java
@Local
public interface IGoalsController {
	public abstract Response create(Goal team);
	public abstract Response update(int id, Goal team);
	public abstract Goal getById(int id);
	public abstract GoalsListResponse getList();
}
```
#### GoalsController
```java
@Path("/goals")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class GoalsController implements IGoalsController{

	@EJB
	GoalRepository repository;
	
	@Override
	@POST
	@Path("/")
	public Response create(Goal goal) {
		repository.create(goal);
		return Response.status(Status.CREATED).entity(goal.getId()).build();
	}

	@Override
	@PUT
	@Path("/{id}")
	public Response update(@PathParam("id") int id, Goal goal) {
		
		try {
			goal.setId(id);
			repository.update(goal);
			return Response.status(Status.OK).build();
		}
		catch(Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@Override
	@GET
	@Path("/{id}")
	public Goal getById(@PathParam("id") int id) {
		return repository.getGoalById(id);
	}

	@Override
	@GET
	@Path("/")
	public GoalsListResponse getList() {
		List<Goal> goals = repository.getList();
		return new GoalsListResponse(goals);
	}
}
```

#### Create
##### Request
* `POST`

```
{
	"time": string,
	"teamName": string,
	"footballer":{
		"id": int,
		"name": string,
		"surname": string,
		"age": int,
		"number": int
	},
	"match":{
		"date": string,
		"time": string,
		"city": string,
		"hostTeam": {
			"id": int,
			"name": string,
			"city": string,
			"league": string
		},
		"guestTeam": {
			"id": int,
			"name": string,
			"city": string,
			"league": string
		}
	}
}
```
##### Response
* `201`
<br>

#### Update
##### Request
* `PUT`
```
{
	"time": string,
	"teamName": string,
	"footballer":{
		"id": int,
		"name": string,
		"surname": string,
		"age": int,
		"number": int
	},
	"match":{
		"date": string,
		"city": string,
		"hostTeam": {
			"id": int,
			"name": string,
			"city": string,
			"league": string
		},
		"guestTeam": {
			"id": int,
			"name": string,
			"city": string,
			"league": string
		}
	}
}
```
##### Response
* `200`
<br>

#### GetById
##### Request
* `GET`
	* `id`

##### Response
* `200`
```
{
	"id": int,
	"time": string,
	"teamName": string
}
```
<br>

#### GetList
##### Request
* `GET`

##### Response
`200`
```
{
    "goals": [
        {
            "id": int,
            "time": string,
            "teamName": string
        }
    ]
}
```