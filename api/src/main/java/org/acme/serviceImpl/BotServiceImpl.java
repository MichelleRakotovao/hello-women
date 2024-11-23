package org.acme.serviceImpl;

import org.acme.services.BotService;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class BotServiceImpl implements BotService {
}
