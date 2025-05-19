package org.sid.examen.mappers;

import org.sid.examen.dtos.*;
import org.sid.examen.entities.*;
import org.sid.examen.enums.StatutCredit;
import org.sid.examen.enums.TypeRemboursement;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class GlobalMapper {

    // ---------- Méthodes utilitaires ----------
    private static Date toDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    private static LocalDate toLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    // ---------- Client ----------
    public static ClientDTO toDTO(Client client) {
        if (client == null) return null;
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setNom(client.getNom());
        dto.setEmail(client.getEmail());
        return dto;
    }

    public static Client toEntity(ClientDTO dto) {
        if (dto == null) return null;
        Client client = new Client();
        client.setId(dto.getId());
        client.setNom(dto.getNom());
        client.setEmail(dto.getEmail());
        return client;
    }

    // ---------- Crédit générique ----------
    public static CreditDTO toDTO(Credit credit) {
        if (credit == null) return null;

        CreditDTO dto;
        if (credit instanceof CreditPersonnel) {
            dto = new CreditPersonnelDTO();
            ((CreditPersonnelDTO) dto).setMotif(((CreditPersonnel) credit).getMotif());
            ((CreditPersonnelDTO) dto).setType("Personnel");
        } else if (credit instanceof CreditImmobilier) {
            dto = new CreditImmobilierDTO();
            ((CreditImmobilierDTO) dto).setTypeBien(((CreditImmobilier) credit).getTypeBien());
            ((CreditImmobilierDTO) dto).setType("Immobilier");
        } else if (credit instanceof CreditProfessionnel) {
            dto = new CreditProfessionnelDTO();
            ((CreditProfessionnelDTO) dto).setMotif(((CreditProfessionnel) credit).getMotif());
            ((CreditProfessionnelDTO) dto).setRaisonSociale(((CreditProfessionnel) credit).getRaisonSociale());
            ((CreditProfessionnelDTO) dto).setType("Professionnel");
        } else {
            dto = new CreditDTO();
        }

        dto.setId(credit.getId());
        dto.setDateDemande(toLocalDate(credit.getDateDemande()).toString());
        dto.setStatut(credit.getStatut().name());
        dto.setDateAcception(credit.getDateAcception() != null ? toLocalDate(credit.getDateAcception()).toString() : null);
        dto.setMontant(credit.getMontant());
        dto.setDuree(credit.getDuree());
        dto.setTauxInteret(credit.getTauxInteret());
        dto.setClientId(credit.getClient() != null ? credit.getClient().getId() : null);

        return dto;
    }

    // ---------- Crédit Personnel ----------
    public static CreditPersonnel toEntity(CreditPersonnelDTO dto, Client client) {
        CreditPersonnel credit = new CreditPersonnel();
        credit.setId(dto.getId());
        credit.setDateDemande(toDate(LocalDate.parse(dto.getDateDemande())));
        credit.setStatut(StatutCredit.valueOf(dto.getStatut()));
        credit.setDateAcception(dto.getDateAcception() != null ? toDate(LocalDate.parse(dto.getDateAcception())) : null);
        credit.setMontant(dto.getMontant());
        credit.setDuree(dto.getDuree());
        credit.setTauxInteret(dto.getTauxInteret());
        credit.setMotif(dto.getMotif());
        credit.setClient(client);
        return credit;
    }

    // ---------- Crédit Immobilier ----------
    public static CreditImmobilier toEntity(CreditImmobilierDTO dto, Client client) {
        CreditImmobilier credit = new CreditImmobilier();
        credit.setId(dto.getId());
        credit.setDateDemande(toDate(LocalDate.parse(dto.getDateDemande())));
        credit.setStatut(StatutCredit.valueOf(dto.getStatut()));
        credit.setDateAcception(dto.getDateAcception() != null ? toDate(LocalDate.parse(dto.getDateAcception())) : null);
        credit.setMontant(dto.getMontant());
        credit.setDuree(dto.getDuree());
        credit.setTauxInteret(dto.getTauxInteret());
        credit.setTypeBien(dto.getTypeBien());
        credit.setClient(client);
        return credit;
    }

    // ---------- Crédit Professionnel ----------
    public static CreditProfessionnel toEntity(CreditProfessionnelDTO dto, Client client) {
        CreditProfessionnel credit = new CreditProfessionnel();
        credit.setId(dto.getId());
        credit.setDateDemande(toDate(LocalDate.parse(dto.getDateDemande())));
        credit.setStatut(StatutCredit.valueOf(dto.getStatut()));
        credit.setDateAcception(dto.getDateAcception() != null ? toDate(LocalDate.parse(dto.getDateAcception())) : null);
        credit.setMontant(dto.getMontant());
        credit.setDuree(dto.getDuree());
        credit.setTauxInteret(dto.getTauxInteret());
        credit.setMotif(dto.getMotif());
        credit.setRaisonSociale(dto.getRaisonSociale());
        credit.setClient(client);
        return credit;
    }

    // ---------- Remboursement ----------
    public static RemboursementDTO toDTO(Remboursement remboursement) {
        if (remboursement == null) return null;
        RemboursementDTO dto = new RemboursementDTO();
        dto.setId(remboursement.getId());
        dto.setDate(toLocalDate(remboursement.getDate()).toString());
        dto.setMontant(remboursement.getMontant());
        dto.setType(remboursement.getType().name());
        dto.setCreditId(remboursement.getCredit() != null ? remboursement.getCredit().getId() : null);
        return dto;
    }

    public static Remboursement toEntity(RemboursementDTO dto, Credit credit) {
        Remboursement remboursement = new Remboursement();
        remboursement.setId(dto.getId());
        remboursement.setDate(toDate(LocalDate.parse(dto.getDate())));
        remboursement.setMontant(dto.getMontant());
        remboursement.setType(TypeRemboursement.valueOf(dto.getType()));
        remboursement.setCredit(credit);
        return remboursement;
    }
}
