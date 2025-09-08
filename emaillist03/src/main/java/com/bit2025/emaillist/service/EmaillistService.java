package com.bit2025.emaillist.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.bit2025.emaillist.repository.EmailRepository;
import com.bit2025.emaillist.repository.EmaillogRepository;
import com.bit2025.emaillist.vo.EmailVo;

@Service
public class EmaillistService {
	@Autowired
	private DataSource dataSource;

	@Autowired
	private EmailRepository emailRepository;

	@Autowired
	private EmaillogRepository emaillogRepository;

	public List<EmailVo> getEmails() {
		return emailRepository.findAll();
	}

	public void addEmail(EmailVo vo) {
		// email_log의 pk : reg_date, 이미 등록된 pk이면 update 결과 == 0
		int count = emaillogRepository.update();

		if (count == 0) {
			emaillogRepository.insert();
		}

		emailRepository.insert(vo);
	}

	// spring이 다음 layer로 트랜잭션을 넘기는 방법
	public void deleteEmail(Long id) {
		// 트랜잭션 동기화(각 Layer의 Connection) 작업 : 초기화
		TransactionSynchronizationManager.initSynchronization();
		Connection conn = DataSourceUtils.getConnection(dataSource);

		try {
			// Transaction : begin
			conn.setAutoCommit(false);

			EmailVo vo = emailRepository.findById(id);
			emailRepository.deleteById(id);
			emaillogRepository.update(vo.getRegDate());

			// Transaction : end(success)
			conn.commit();
		} catch (Throwable e) {
			try {
				// Transaction : end(fail)
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException(e);
		} finally {
			DataSourceUtils.releaseConnection(conn, dataSource);
		}
	}

}
