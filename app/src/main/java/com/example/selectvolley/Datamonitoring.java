package com.example.selectvolley;

public class Datamonitoring {
    private String idm;
    private String tglm;
    private String nis;
    private String jam;
    private String kegiatan;
    private String lokasi;
    private String user;
    private Byte foto;
    public Datamonitoring() {

    }

    public String getIdm() {
        return idm;
    }

    public void setIdm(String idm) {
        this.idm = idm;
    }

    public String getTglm() {
        return tglm;
    }

    public void setTglm(String tglm) {
        this.tglm = tglm;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getKegiatan() {
        return kegiatan;
    }

    public void setKegiatan(String kegiatan) {
        this.kegiatan = kegiatan;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Byte getFoto() {
        return foto;
    }

    public void setFoto(Byte foto) {
        this.foto = foto;
    }

    public Datamonitoring(String idm, String tglm, String nis, String jam, String kegiatan, String lokasi, String user, Byte foto){
        this.idm=idm;
        this.tglm=tglm;
        this.nis=nis;
        this.jam=jam;
        this.kegiatan=kegiatan;
        this.lokasi=lokasi;
        this.user=user;
        this.foto=foto;


    }

}
