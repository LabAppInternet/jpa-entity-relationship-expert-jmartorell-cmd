package cat.tecnocampus.notes2425.domain;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    UserLab owner;

    String title;
    String context;
    LocalDateTime creationDate;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "note_tag",
            joinColumns = @JoinColumn(name = "node_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    Set<Tag> tags;

    public Note(String title, String context) {
        this.creationDate = LocalDateTime.now();
        this.title = title;
        this.context = context;
        tags = new HashSet<>();
    }

    public UserLab getOwner() {
        return owner;
    }
    public void setOwner(UserLab owner) {
        this.owner = owner;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContext() {
        return context;
    }
    public void setContext(String context) {
        this.context = context;
    }
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public Set<Tag> getTags() {
        return tags;
    }
    public Long getId() {
        return id;
    }
    public void addTag(Tag tag) {
        tags.add(tag);
        tag.addNote(this);
    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
        tag.removeNote(this);
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Note){
            return ((Note)o).getId() == id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
