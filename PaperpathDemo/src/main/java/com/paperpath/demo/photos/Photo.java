package com.paperpath.demo.photos;

import com.paperpath.demo.photorequests.PhotoRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "photo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id")
    private long photoId;

    private String name;
    private String type;

    @Lob
    @Column(name = "picture", columnDefinition = "LONGBLOB")
    public byte[] picture;

    @OneToOne(mappedBy = "photoObjInRequest")
    private PhotoRequest requestObjInPhoto;

    public Photo(String name, String type, byte[] picture) {
        this.name = name;
        this.type = type;
        this.picture = picture;
    }

    public String getImage() {
        return Base64.encodeBase64String(this.picture);
    }
}
