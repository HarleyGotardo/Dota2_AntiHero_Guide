public class Hero 
{
    String name;
    Role[] role;
    String[] goodAgainst;
    Attribute mainAttribute;

    public Hero(String name,Attribute mainAttribute, Role[] role, String[] goodAgainst)
    {
        this.name = name;
        this.role = role;
        this.goodAgainst = goodAgainst;
        this.mainAttribute = mainAttribute;
    }

    public String getName()
    {
        return this.name;
    }

    public Role[] getRole()
    {
        return this.role;
    }

    public String getRoleString() 
    {
        StringBuilder rolesString = new StringBuilder();
        for (int i = 0; i < role.length; i++) {
            rolesString.append(role[i]);
            if (i < role.length - 1) {
                rolesString.append(", ");
            }
        }
        return "ROLES: " + rolesString.toString();
    }

    public String[] getGoodAgainst() 
    {
        return this.goodAgainst;
    }

    public Attribute getMainAttribute() 
    {
        return this.mainAttribute;
    }

    @Override
    public String toString() {
        StringBuilder rolesString = new StringBuilder();
        for (int i = 0; i < role.length; i++) {
            rolesString.append(role[i]);
            if (i < role.length - 1) {
                rolesString.append(", ");
            }
        }
    
        return "Hero Name: " + this.name + "\n" +
                "Roles: " + rolesString.toString() + "\n" +
                "Main Attribute: " + this.mainAttribute;
    }
}
