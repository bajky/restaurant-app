package mainpackage;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Bajky on 23.8.2015.
 */
@Repository
public class VotesDaoImpl extends GenericDaoImpl<Votes> implements VotesDao {
    @Override
    public List<VotesVO> getVotesByUser(long userID) {
        List<VotesVO> resultList = entityManager.createNamedQuery(Votes.SELECT_VOTES_BY_USERS, VotesVO.class)
                .setParameter("userID", userID)
                .getResultList();

        return resultList;
    }
}
