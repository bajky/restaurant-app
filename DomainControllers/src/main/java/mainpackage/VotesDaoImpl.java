package mainpackage;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Bajky on 23.8.2015.
 */
@Repository
public class VotesDaoImpl extends GenericDaoImpl<Votes> implements VotesDao {
    @Override
    public List<Object[]> getVotesByUser(long userID) {
        return entityManager.createNamedQuery(Votes.SELECT_VOTES_BY_USERS)
                .setParameter("userID", userID)
                .getResultList();
    }
}
