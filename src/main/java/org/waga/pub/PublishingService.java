package org.waga.pub;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.waga.news.NewsItem;
import org.waga.player.PlayerRepository;

@Component
public class PublishingService {

	private static final Logger logger = LoggerFactory.getLogger(PublishingService.class);

	private static final String DEFAULT_FROM_ADDRESS = "mail@thewaga.com";
	private JavaMailSender mailSender;
	private PlayerRepository playerRepository;

	@Autowired
	public PublishingService(JavaMailSender mailSender, PlayerRepository playerRepository) {
		this.mailSender = mailSender;
		this.playerRepository = playerRepository;
	}

	public void publishNews(NewsItem item) {

		List<String> addresses = playerRepository.findByEmailAddressIsNotNull().stream()
				.map(p -> p.getEmailAddress().getAddress()).collect(Collectors.toList());

		logger.debug("Sending email to: {}", addresses);

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(DEFAULT_FROM_ADDRESS);
		msg.setTo(addresses.toArray(new String[] {}));
		msg.setSubject(item.getTitle());
		msg.setText(generateText(item));

		try {
			mailSender.send(msg);
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	private String generateText(NewsItem item) {
		return item.getSummary() + signature() + site();
	}

	private String site() {
		return "\n\nhttp://www.thewaga.com";
	}

	private String signature() {
		return "\n\nThe WAGA";
	}

}
