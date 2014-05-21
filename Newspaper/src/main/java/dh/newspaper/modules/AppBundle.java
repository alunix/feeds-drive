package dh.newspaper.modules;

import android.util.Log;
import de.greenrobot.event.EventBus;
import dh.newspaper.MyApplication;
import dh.newspaper.model.Category;
import dh.newspaper.model.FeedItem;
import dh.newspaper.view.CategoriesFragment;
import dh.newspaper.view.FeedsFragment;

import javax.inject.Inject;

/**
 * Store all information to initialize fragment/activity which is not ready to receive event from EventBus
 * onEvent here has a higher priority (100) than default (0)
 * Created by hiep on 17/05/2014.
 */
public class AppBundle {
	private static final String TAG = AppBundle.class.getName();

	private FeedItem currentFeedItem;
	private int currentCategoryId;

	@Inject
	public AppBundle() {}

	public void onEvent(FeedsFragment.Event e) {
		try {
			if (!FeedsFragment.Event.ON_ITEM_SELECTED.equals(e.getSubject())) {
				return;
			}
			currentFeedItem = e.getFeedItem();
		}catch (Exception ex) {
			Log.w(TAG, ex);
		}
	}

	public void onEvent(CategoriesFragment.Event e) {
		try {
			currentCategoryId = e.getCategoryId();
		} catch (Exception ex) {
			Log.w(TAG, ex);
		}
	}

	public FeedItem getCurrentFeedItem() {
		return currentFeedItem;
	}

	public int getCurrentCategoryId() {
		return currentCategoryId;
	}
}