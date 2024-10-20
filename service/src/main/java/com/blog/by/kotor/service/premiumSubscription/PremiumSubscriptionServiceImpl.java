package com.blog.by.kotor.service.premiumSubscription;

import com.blog.by.kotor.PremiumSubscriptionDTOMapper;
import com.blog.by.kotor.dto.model.PremiumSubscriptionDTO;
import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.create.CreateException;
import com.blog.by.kotor.exception.find.by.id.FindByIdException;
import com.blog.by.kotor.model.PremiumSubscription;
import com.blog.by.kotor.repository.PremiumSubscriptionRepository;
import com.blog.by.kotor.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PremiumSubscriptionServiceImpl implements PremiumSubscriptionService {

    private final PremiumSubscriptionRepository premiumSubscriptionRepository;

    private final PremiumSubscriptionDTOMapper premiumSubscriptionDTOMapper;

    private final UserService userService;

    @Override
    @Transactional
    public void createPremiumSubscription(PremiumSubscriptionDTO premiumSubscriptionDTO) {
        if (premiumSubscriptionDTO.getUserId() == null) {
            throw new CreateException(ErrorCode.PREMIUM_SUBSCRIPTION_USER_ID);
        }

        PremiumSubscription premiumSubscription = premiumSubscriptionDTOMapper.toPremiumSubscription(premiumSubscriptionDTO);
        premiumSubscription.setUser(userService.findUserById(premiumSubscriptionDTO.getUserId()));
        premiumSubscriptionRepository.save(premiumSubscription);
    }

    @Override
    public PremiumSubscription findPremiumSubscriptionById(Integer id) {
        return premiumSubscriptionRepository.findById(id)
                .orElseThrow(() -> new FindByIdException(ErrorCode.PREMIUM_SUBSCRIPTION_NOT_FOUND, id));

    }

    @Override
    public List<PremiumSubscription> findAllPremiumSubscription() {
        return premiumSubscriptionRepository.findAll();
    }

    //Доработать или убрать...
    @Deprecated
    @Override
    @Transactional
    public void updatePremiumSubscription(PremiumSubscriptionDTO premiumSubscriptionDTO, Integer id) {
        this.findPremiumSubscriptionById(id);

        PremiumSubscription premiumSubscription = premiumSubscriptionDTOMapper.toPremiumSubscription(premiumSubscriptionDTO);
        premiumSubscription.setUser(userService.findUserById(premiumSubscriptionDTO.getUserId()));
        premiumSubscription.setId(id);
        premiumSubscriptionRepository.save(premiumSubscription);
    }

    @Override
    @Transactional
    public void deletePremiumSubscriptionById(Integer id) {
        this.findPremiumSubscriptionById(id);
        premiumSubscriptionRepository.deleteById(id);
    }

}
