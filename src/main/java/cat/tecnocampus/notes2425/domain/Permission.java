package cat.tecnocampus.notes2425.domain;

import jakarta.persistence.*;

@Entity
public class Permission {
    @EmbeddedId
    private NotePermissionId id;

    private boolean CanRead;
    private boolean CanEdit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "note_Id")
    private Note note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_Id")
    private UserLab owner;

    public Permission(UserLab owner, Note note) {
        this.id = new NotePermissionId(note.getId(), owner.getId());
        this.note = note;
        this.owner = owner;
    }

    public Permission() {}

    public NotePermissionId getId() {
        return id;
    }
    public Note getNote(){
        return note;
    }
    public UserLab getOwner() {
        return owner;
    }

    public void setCanRead(boolean CanRead) {
        this.CanRead = CanRead;
    }
    public void setCanEdit(boolean CanEdit) {
        this.CanEdit = CanEdit;
    }

    public boolean isCanEdit() {
        return CanEdit;
    }
    public boolean isCanRead() {
        return CanRead;
    }
}
