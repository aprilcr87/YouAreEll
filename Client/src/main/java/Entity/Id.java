package Entity;

public class Id {
private Integer userId;
private String name;
private String githubId;

    public Id() {
    }

    public Id(Integer userId, String name, String githubName) {
        this.userId = userId;
        this.name = name;
        this.githubId = githubName;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGithubName() {
        return githubId;
    }

    public void setGithubName(String githubName) {
        this.githubId = githubId;
    }

    @Override
    public String toString() {
        return "Entity.Id{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", githubName='" + githubId + '\'' +
                '}';
    }
}
