/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.twitter.api;

import org.springframework.social.twitter.api.impl.Coordinates;

import java.io.Serializable;
import java.util.Date;

/**
 * Represents a Twitter status update (e.g., a "tweet").
 * @author Craig Walls
 */
public class Tweet extends TwitterObject implements Serializable {
	private static final long serialVersionUID = 1L;

	private final long id;
	private final String text;
	private final Date createdAt;
	private String fromUser;
	private String profileImageUrl;
	private Long toUserId;
	private Long inReplyToStatusId;
	private Long inReplyToUserId;
	private String inReplyToScreenName;
	private long fromUserId;
	private String languageCode;
	private String source;
	private Integer retweetCount;
	private boolean retweeted;
	private Tweet retweetedStatus;
	private boolean favorited;
	private Integer favoriteCount;
	private Entities entities;
	private TwitterProfile user;
    private Coordinates coordinates;
    private Place place;

	public Tweet(long id, String text, Date createdAt, String fromUser, String profileImageUrl, Long toUserId, long fromUserId, String languageCode, String source) {
		this.id = id;
		this.text = text;
		this.createdAt = createdAt;
		this.fromUser = fromUser;
		this.profileImageUrl = profileImageUrl;
		this.toUserId = toUserId;
		this.fromUserId = fromUserId;
		this.languageCode = languageCode;
		this.source = source;		
	}

	/**
	 * The text of the tweet. If this tweet is a retweet of another tweet, the text may be preceeded with "RT \@someuser" and may be truncated at the end.
	 * To get the raw, unmodified text of the original tweet, use {@link #getUnmodifiedText()}. 
	 * @return The text of the tweet.
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Returns the unmodified text of the tweet.
	 * If this tweet is a retweet, it returns the text of the original tweet.
	 * If it is not a retweet, then this method will return the same value as {@link #getText()}.
	 * @return The unmodified text of the tweet.
	 */
	public String getUnmodifiedText() {
		return isRetweet() ? retweetedStatus.getText() : getText();
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public long getId() {
		return id;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public Long getToUserId() {
		return toUserId;
	}

	public void setToUserId(Long toUserId) {
		this.toUserId = toUserId;
	}

	public long getFromUserId() {
		return fromUserId;
	}
	
	public void setInReplyToStatusId(Long inReplyToStatusId) {
		this.inReplyToStatusId = inReplyToStatusId;
	}
	
	public Long getInReplyToStatusId() {
		return inReplyToStatusId;
	}

	public void setFromUserId(long fromUserId) {
		this.fromUserId = fromUserId;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setRetweetCount(Integer retweetCount) {
		this.retweetCount = retweetCount;		
	}
	
	/**
	 * The number of times this tweet has been retweeted.
	 * Only available in timeline results. 
	 * getRetweetCount() will return null for Tweet objects returned in search results.
	 * @return the number of times the tweet has been retweeted or null if that information is unavailable
	 */
	public Integer getRetweetCount() {
		return retweetCount;
	}
	
	public void setRetweeted(boolean retweeted) {
		this.retweeted = retweeted;
	}

	public boolean isRetweeted() {
		return retweeted;
	}
	
	public Tweet getRetweetedStatus() {
		return this.retweetedStatus;
	}

	public void setRetweetedStatus(final Tweet tweet) {
		this.retweetedStatus = tweet;
	}
	
	public boolean isRetweet() {
		return this.retweetedStatus != null;
	}

	public void setFavorited(boolean favorited) {
		this.favorited = favorited;
	}

	public boolean isFavorited() {
		return favorited;
	}
	
	public void setFavoriteCount(Integer favoriteCount) {
		this.favoriteCount = favoriteCount;
	}
	
	public Integer getFavoriteCount() {
		return favoriteCount;
	}

	public Entities getEntities() {
		return this.entities;
	}
	
	public void setEntities(final Entities ent) {
		this.entities = ent;
	}

	public boolean hasMentions() {
		if (this.entities == null) {
			return false;
		}
		return !this.entities.getMentions().isEmpty();
	}

	public boolean hasMedia() {
		if (this.entities == null) {
			return false;
		}
		return !this.entities.getMedia().isEmpty();
	}

	public boolean hasUrls() {
		if (this.entities == null) {
			return false;
		}
		return !this.entities.getUrls().isEmpty();
	}

	public boolean hasTags() {
		if (this.entities == null) {
			return false;
		}
		return !this.entities.getHashTags().isEmpty();
	}
	
	public TwitterProfile getUser() {
		return this.user;
	}
	
	public void setUser(final TwitterProfile prof) {
		this.user = prof;
	}

	public Long getInReplyToUserId() {
		return inReplyToUserId;
	}

	public void setInReplyToUserId(final Long inReplyToUserId) {
		this.inReplyToUserId = inReplyToUserId;
	}

	public String getInReplyToScreenName() {
		return inReplyToScreenName;
	}

	public void setInReplyToScreenName(final String inReplyToScreenName) {
		this.inReplyToScreenName = inReplyToScreenName;
	}

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Tweet tweet = (Tweet) o;

		if (fromUserId != tweet.fromUserId) {
			return false;
		}
		if (id != tweet.id) {
			return false;
		}
		if (retweeted != tweet.retweeted) {
			return false;
		}
		if (createdAt != null ? !createdAt.equals(tweet.createdAt) : tweet.createdAt != null) {
			return false;
		}
		if (entities != null ? !entities.equals(tweet.entities) : tweet.entities != null) {
			return false;
		}
		if (fromUser != null ? !fromUser.equals(tweet.fromUser) : tweet.fromUser != null) {
			return false;
		}
		if (inReplyToScreenName != null ? !inReplyToScreenName.equals(tweet.inReplyToScreenName) : tweet.inReplyToScreenName != null) {
			return false;
		}
		if (inReplyToStatusId != null ? !inReplyToStatusId.equals(tweet.inReplyToStatusId) : tweet.inReplyToStatusId != null) {
			return false;
		}
		if (inReplyToUserId != null ? !inReplyToUserId.equals(tweet.inReplyToUserId) : tweet.inReplyToUserId != null) {
			return false;
		}
		if (languageCode != null ? !languageCode.equals(tweet.languageCode) : tweet.languageCode != null) {
			return false;
		}
		if (profileImageUrl != null ? !profileImageUrl.equals(tweet.profileImageUrl) : tweet.profileImageUrl != null) {
			return false;
		}
		if (retweetCount != null ? !retweetCount.equals(tweet.retweetCount) : tweet.retweetCount != null) {
			return false;
		}
		if (retweetedStatus != null ? !retweetedStatus.equals(tweet.retweetedStatus) : tweet.retweetedStatus != null) {
			return false;
		}
		if (source != null ? !source.equals(tweet.source) : tweet.source != null) {
			return false;
		}
		if (text != null ? !text.equals(tweet.text) : tweet.text != null) {
			return false;
		}
		if (toUserId != null ? !toUserId.equals(tweet.toUserId) : tweet.toUserId != null) {
			return false;
		}
		if (user != null ? !user.equals(tweet.user) : tweet.user != null) {
			return false;
		}
        if (coordinates != null ? !coordinates.equals(tweet.coordinates) : tweet.coordinates != null) {
            return false;
        }
        if (place != null ? !place.equals(tweet.coordinates) : tweet.place!= null) {
            return false;
        }

		return true;
	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (text != null ? text.hashCode() : 0);
		result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
		result = 31 * result + (fromUser != null ? fromUser.hashCode() : 0);
		result = 31 * result + (profileImageUrl != null ? profileImageUrl.hashCode() : 0);
		result = 31 * result + (toUserId != null ? toUserId.hashCode() : 0);
		result = 31 * result + (inReplyToStatusId != null ? inReplyToStatusId.hashCode() : 0);
		result = 31 * result + (inReplyToUserId != null ? inReplyToUserId.hashCode() : 0);
		result = 31 * result + (inReplyToScreenName != null ? inReplyToScreenName.hashCode() : 0);
		result = 31 * result + (int) (fromUserId ^ (fromUserId >>> 32));
		result = 31 * result + (languageCode != null ? languageCode.hashCode() : 0);
		result = 31 * result + (source != null ? source.hashCode() : 0);
		result = 31 * result + (retweetCount != null ? retweetCount.hashCode() : 0);
		result = 31 * result + (retweeted ? 1 : 0);
		result = 31 * result + (retweetedStatus != null ? retweetedStatus.hashCode() : 0);
		result = 31 * result + (entities != null ? entities.hashCode() : 0);
		result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
		return result;
	}
}