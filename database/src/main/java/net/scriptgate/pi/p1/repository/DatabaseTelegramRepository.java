package net.scriptgate.pi.p1.repository;

import net.scriptgate.pi.p1.model.DatabaseTelegram;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface DatabaseTelegramRepository extends JpaRepository<DatabaseTelegram, Date> {

}
