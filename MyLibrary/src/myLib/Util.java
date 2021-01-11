package myLib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * A class containing static utility methods
 *
 * @author knerd.knitter
 */
public class Util
{
    /**
     * Check if the given String is <b>{@code null}</b> or equal to an empty String ({@code ""})
     *
     * @param str
     *            the String to check
     * @return a boolean indicating if the String is empty
     */
    public static boolean isBlank( String str )
    {
        return str == null || str.equals( "" );
    }

    /**
     * Check if a given {@link Collection} is <b>{@code null}</b> or has no items
     *
     * @param list
     *            the {@link Collection} to check
     * @return a boolean indicating if the {@link Collection} is empty
     */
    public static boolean isEmpty( Collection<?> list )
    {
        return list == null || list.size() == 0;
    }

    /**
     * Check if a given {@link HashMap} is <b>{@code null}</b> or has no entries
     *
     * @param map
     *            a {@link HashMap} to check
     * @return a boolean indicating if the {@link HashMap} is empty
     */
    public static boolean isEmpty( HashMap<?, ?> map )
    {
        return map == null || map.size() == 0;
    }

    /**
     * Return a boolean indicating if {@code string1} is lexicographically before {@code string2} (call {@link String#compareTo(String)} on {@code string1} with
     * {@code string2}) and return <b>{@code true}</b> if the result is less than <b>{@code 0}</b>)
     *
     * @param string1
     *            a String representing the first String
     * @param string2
     *            a String representing the second String
     * @return a boolean indicating if the first String is before the second String
     */
    public static boolean isString1BeforeString2( String string1, String string2 )
    {
        return string1.compareTo( string2 ) < 0;
    }

    /**
     * Return the array of objects as a comma-separated list in a String
     *
     * @param objList
     *            an array of Objects
     * @return a String representing a comma-separated list of the objects
     */
    protected static String join( Object[] objList )
    {
        StringBuffer sb = new StringBuffer();
        if( objList != null && objList.length > 0 )
        {
            for( int i = 0; i < objList.length; i++ )
            {
                sb.append( i == 0 ? "" : ", " ).append( objList[ i ] == null ? "null" : objList[ i ].toString() );
            }
        }
        return sb.toString();
    }

    /**
     * Returns a boolean indicating if the lists are the same size and contain the same items (does not check order)
     *
     * @param list1
     *            a {@link List} of objects
     * @param list2
     *            a {@link List} of objects
     * @return a boolean indicating if the lists match
     */
    public static boolean listsMatch( List<?> list1, List<?> list2 )
    {
        boolean retVal = true;
        int l1size = list1 == null ? 0 : list1.size();
        int l2size = list2 == null ? 0 : list2.size();
        if( l1size != l2size || isEmpty( list1 ) != isEmpty( list2 ) )
        {
            retVal = false;
        }
        else if( list1 != null && list2 != null )
        {
            for( Object o : list1 )
            {
                if( !list2.contains( o ) )
                {
                    retVal = false;
                    break;
                }
            }
        }
        return retVal;
    }

    /**
     * description Returns a boolean indicating if the lists are the same size and contain the same items, checking order
     *
     * @param list1
     *            a {@link List} of Strings
     * @param list2
     *            a {@link List} of Strings
     * @return a boolean indicating if the lists match
     */
    public static boolean listsMatchOrder( List<String> list1, List<String> list2 )
    {
        boolean retVal = true;
        int l1size = list1 == null ? 0 : list1.size();
        int l2size = list2 == null ? 0 : list2.size();
        if( l1size != l2size || isEmpty( list1 ) != isEmpty( list2 ) )
        {
            retVal = false;
        }
        else if( list1 != null && list2 != null )
        {
            for( int i = 0; i < list1.size(); i++ )
            {
                if( !stringsMatch( list1.get( i ), list2.get( i ) ) )
                {
                    retVal = false;
                    break;
                }
            }
        }
        return retVal;
    }

    /**
     * Return a list of Strings as a single comma-separated String
     *
     * @param options
     *            the list of items to print
     * @return a String representing the list
     */
    public static String print( Collection<?> options )
    {
        return options == null ? "empty list" : join( options.toArray() );
    }

    /**
     * Returns a String representing the given map
     *
     * @param map
     *            a {@link HashMap} to represent as a String
     * @return a String representing the given map
     */
    public static String print( HashMap<?, ?> map )
    {
        List<Object> list = new ArrayList<Object>();
        if( map != null && !map.isEmpty() )
        {
            for( Entry<?, ?> e : map.entrySet() )
            {
                list.add( String.format( "%s=%s",
                                         e.getKey(),
                                         e.getValue() == null ? "null" : e.getValue().toString() ) );
            }
        }
        return list.isEmpty() ? "empty map" : join( list.toArray() );
    }

    /**
     * Return a boolean indicating if the given Strings are the same:
     * <ul>
     * <li>If the result of calling {@link #isBlank(String)} with {@code string1} is <b>{@code true}</b>, then return the result of calling
     * {@link #isBlank(String)} with {@code string2}</li>
     * <li>Otherwise, return the result of calling {@link String#equals(Object)} on {@code string1} with {@code string2}</li>
     * </ul>
     *
     * @param string1
     *            the first String to check
     * @param string2
     *            the second String to check
     * @return a boolean indicating if the Strings are the same
     */
    public static boolean stringsMatch( String string1, String string2 )
    {
        return isBlank( string1 ) ? isBlank( string2 ) : string1.equals( string2 );
    }
}