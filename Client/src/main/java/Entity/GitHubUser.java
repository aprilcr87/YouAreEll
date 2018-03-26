package Entity;

public class GitHubUser {

    String github;
    String name;
    String userid;

    public GitHubUser(String github, String name, String userId) {
        this.github = github;
        this.name = name;
        this.userid = userId;
    }

    public GitHubUser(){}

    public String getGithub() {

        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getuserid() {
        return userid;
    }

    public void setuserid(String userId) {
        this.userid = userId;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Github: " + this.github + "\n");
        stringBuilder.append("User ID: " + this.userid + "\n");
        stringBuilder.append("Name: " + this.name + "\n");
        return stringBuilder.toString();
    }
}
