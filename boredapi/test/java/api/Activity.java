package api;

public class Activity
{
    private String activity;
    private double accessibility;
    private Type type;
    private int participants;
    private double price;
    private String link;
    private int key;

    public String getActivity()
    {
        return activity;
    }

    public void setActivity(String activity)
    {
        this.activity = activity;
    }

    public double getAccessibility()
    {
        return accessibility;
    }

    public void setAccessibility(double accessibility)
    {
        this.accessibility = accessibility;
    }

    public Type getType()
    {
        return type;
    }

    public void setType(Type type)
    {
        this.type = type;
    }

    public int getParticipants()
    {
        return participants;
    }

    public void setParticipants(int participants)
    {
        this.participants = participants;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    public int getKey()
    {
        return key;
    }

    public void setKey(int key)
    {
        this.key = key;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        else if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        else
        {
            Activity that = (Activity) obj;
            return this.activity.equals(that.activity) &&
                   this.accessibility == that.accessibility &&
                   this.type == that.type &&
                   this.participants == that.participants &&
                   this.price == that.price &&
                   this.link.equals(that.link) &&
                   this.key == that.key;

        }
    }
}
