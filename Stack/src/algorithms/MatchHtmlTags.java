package algorithms;
/* 
@Author: mohammed.shalan 
@Date: 14-Jul-22
*/

import interfaces.Stack;
import stack.NodeStack;

public class MatchHtmlTags {


    /***
     * Stripe the first and last char off a <tag>
     * @param tag
     * @return
     */
    public String stripTag(String tag) {
        if (tag.length() <= 2) return null;
        return tag.substring(1, tag.length() - 1);
    }

    /**
     * Check if the tag is opening tag or not.
     *
     * @param tag The tag will be checked.
     * @return True if the tag is not starting with '/'
     */
    public boolean isOpeningTag(String tag) {
        return (tag==null) || (tag.length() == 0) || tag.charAt(0) != '/';
    }

    /***
     *  Check if two tags are matching which means open and close tag. <tag></tag>
     * @param tag1 The first tag without <> e.g tag
     * @param tag2 the second tag without <> e.g /tag
     * @return True if the tags are equal otherwise, false.
     */
    public boolean areMatchingTags(String tag1, String tag2) {
        return tag1.equals(tag2.substring(1));
    }

    /**
     * Take the stripped tags and check if every tag have its close tag.
     * @param tags Sripped tags e.g ['tag','/tag']
     * @return true if every tag have its close tag.
     */
    public boolean isHTMLMatched(String[] tags) {
        Stack<String> stack = new NodeStack<>();
        for (int i = 0; i < tags.length; i++) {
            if(isOpeningTag(tags[i])){
                stack.push(tags[i]);
            }else{
                if(stack.isEmpty())
                    return false;
                if(!areMatchingTags(stack.pop(),tags[i]))
                    return false;
            }
        }

        if(stack.isEmpty()) return true;

        return false;
    }

}
