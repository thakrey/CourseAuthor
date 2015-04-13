package com.lrn.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BeanUtils implements Constants
{

    public BeanUtils()
    {
    }

    public static final void copyProperties(Object source, Object target)
    {
        if(source == null || target == null)
            return;
        
        HashMap sourceMethods = getMethodMap(source.getClass().getMethods(), "get");
        
        HashMap targetMethods = getMethodMap(target.getClass().getMethods(), "set");
        resetToDefaultValues(target, targetMethods);
        
        Object value = null;
        Method method = null;
        ArrayList requiredMethods = new ArrayList(sourceMethods.values());
        for(int index = 0; index < requiredMethods.size(); index++)
        {
            method = (Method)requiredMethods.get(index);
            try
            {
                value = method.invoke(source, null);
        
                method = (Method)targetMethods.get(getMethodName(method));
                if(method != null && value != null)
                    setValue(target, method, value);
            }
            catch(Exception e)
            {
        
            }
        }

        
    }

    public static final void copyProperties(Object source, Object target, String properties)
    {   
        if(source == null || target == null)
            return;
        if(properties == null || properties.trim().length() == 0)
            return;
        
        HashMap sourceMethods = getMethodMap(source.getClass().getMethods(), "get");
        HashMap targetMethods = getMethodMap(target.getClass().getMethods(), "set");
        
        Object value = null;
        Method method = null;
        String property = null;
        if(properties != null)
        {
            for(StringTokenizer tokenizer = new StringTokenizer(properties, ","); tokenizer.hasMoreTokens();)
            {
                property = tokenizer.nextToken();
                method = (Method)sourceMethods.get("get" + property.toLowerCase());
                if(method != null)
                {
        
                    try
                    {
                        value = method.invoke(source, null);
        
                        method = (Method)targetMethods.get(getMethodName(method));
                        if(method != null && value != null)
                            setValue(target, method, value);
                    }
                    catch(Exception e)
                    {
        
                    }
                }
            }

        }
        
    }

    private static final HashMap getMethodMap(Method methods[], String prefix)
    {   
        HashMap methodMap = new HashMap();
        for(int i = 0; i < methods.length; i++)
            if(methods[i].getName().startsWith(prefix))
                methodMap.put(methods[i].getName().toLowerCase(), methods[i]);

        
        return methodMap;
    }

    private static final void setValue(Object dynObject, Method method, Object value)
    {   
        try
        {
            String paramType = method.getParameterTypes()[0].getName();
        
            if(paramType.equalsIgnoreCase("java.lang.String"))
            {
        
                if(value instanceof Date)
                    method.invoke(dynObject, new Object[] {
                        DateUtil.toString((Date)value)
                    });
                else
                if(value instanceof java.util.Date)
                    method.invoke(dynObject, new Object[] {
                        DateUtil.toString((java.util.Date)value)
                    });
                else
                    method.invoke(dynObject, new Object[] {
                        value.toString()
                    });
        
            } else
            if(paramType.equalsIgnoreCase("java.lang.StringBuffer"))
            {
        
                method.invoke(dynObject, new Object[] {
                    new StringBuffer(value.toString())
                });
        
            } else
            if(paramType.equalsIgnoreCase("short") || paramType.equalsIgnoreCase("java.lang.Short"))
            {
        
                method.invoke(dynObject, new Object[] {
                    new Short(value.toString())
                });
        
            } else
            if(paramType.equalsIgnoreCase("int") || paramType.equalsIgnoreCase("java.lang.Integer"))
            {
        
                method.invoke(dynObject, new Object[] {
                    new Integer(value.toString())
                });
        
            } else
            if(paramType.equalsIgnoreCase("long") || paramType.equalsIgnoreCase("java.lang.Long"))
            {
        
                method.invoke(dynObject, new Object[] {
                    new Long(value.toString())
                });
        
            } else
            if(paramType.equalsIgnoreCase("double") || paramType.equalsIgnoreCase("java.lang.Double"))
            {
        
                method.invoke(dynObject, new Object[] {
                    new Double(value.toString())
                });
        
            } else
            if(paramType.equalsIgnoreCase("float") || paramType.equalsIgnoreCase("java.lang.Float"))
            {
        
                method.invoke(dynObject, new Object[] {
                    new Float(value.toString())
                });
        
            } else
            if(paramType.equalsIgnoreCase("boolean") || paramType.equalsIgnoreCase("java.lang.Boolean"))
            {
        
                method.invoke(dynObject, new Object[] {
                    new Boolean(value.toString())
                });
        
            } else
            if(paramType.equalsIgnoreCase("java.util.Date"))
            {
        
                method.invoke(dynObject, new Object[] {
                    DateUtil.toSqlDate(value.toString())
                });
        
            } else
            if(paramType.equalsIgnoreCase("java.sql.Date"))
            {
                Date date = null;
        
                date = DateUtil.toSqlDate(value.toString());
        
                method.invoke(dynObject, new Object[] {
                    date
                });
            } else
            if(paramType.equalsIgnoreCase("java.sql.Timestamp"))
            {
                java.util.Date utilDate = null;
                try
                {
                    utilDate = DateUtil.toUtilDate(value.toString());
        
                    method.invoke(dynObject, new Object[] {
                        new Timestamp(utilDate.getTime())
                    });
                }
                catch(Exception eee)
                {
        
                    
                }
        
            } else
            if(paramType.equalsIgnoreCase("java.util.ArrayList"))
            {
        
                method.invoke(dynObject, new Object[] {
                    (ArrayList)value
                });
        
            } else
            if(paramType.equalsIgnoreCase("java.util.Set"))
            {
        
                method.invoke(dynObject, new Object[] {
                    new HashSet((Set)value)
                });
        
            } else
            if(paramType.equalsIgnoreCase("java.util.List"))
            {
        
                method.invoke(dynObject, new Object[] {
                    (List)value
                });
        
            } else
            {
        
                method.invoke(dynObject, new Object[] {
                    value
                });
        
            }
        }
        catch(Exception e)
        {
        
        }
        finally
        {
        
        }
        return;
    }

    private static String getMethodName(Method method)
    {   
        String methodName = null;
        if(method != null)
        {
            methodName = method.getName();
            if(methodName.startsWith("get"))
                methodName = "set" + methodName.substring(3).toLowerCase();
        }
        
        return methodName;
    }

    private static void resetToDefaultValues(Object target, HashMap getMethods)
    {   
        Method method = null;
        String paramType = null;
        Collection methods = getMethods.values();
        for(Iterator iterator = methods.iterator(); iterator.hasNext();)
        {
            method = (Method)iterator.next();
            if(method != null)
            {
                Class parameterTypes[] = method.getParameterTypes();
                if(parameterTypes != null && parameterTypes.length > 0)
                    try
                    {
                        paramType = parameterTypes[0].getName();
                        if("java.lang.String".equalsIgnoreCase(paramType))
                            method.invoke(target, new Object[] {
                                (new StringBuffer()).toString()
                            });
                        else
                        if("java.lang.StringBuffer".equalsIgnoreCase(paramType))
                            method.invoke(target, new Object[] {
                                new StringBuffer()
                            });
                        else
                        if("short".equalsIgnoreCase(paramType) || "java.lang.Short".equalsIgnoreCase(paramType))
                            method.invoke(target, new Object[] {
                                new Short(DEFAULT_SHORT)
                            });
                        else
                        if("int".equalsIgnoreCase(paramType) || "java.lang.Integer".equalsIgnoreCase(paramType))
                            method.invoke(target, new Object[] {
                                new Integer(DEFAULT_INT)
                            });
                        else
                        if("long".equalsIgnoreCase(paramType) || "java.lang.Long".equalsIgnoreCase(paramType))
                            method.invoke(target, new Object[] {
                                new Long(DEFAULT_LONG)
                            });
                        else
                        if("double".equalsIgnoreCase(paramType) || "java.lang.Double".equalsIgnoreCase(paramType))
                            method.invoke(target, new Object[] {
                                new Double(DEFAULT_DOUBLE)
                            });
                        else
                        if("float".equalsIgnoreCase(paramType) || "java.lang.Float".equalsIgnoreCase(paramType))
                            method.invoke(target, new Object[] {
                                new Float(DEFAULT_FLOAT)
                            });
                        else
                        if("boolean".equalsIgnoreCase(paramType) || "java.lang.Boolean".equalsIgnoreCase(paramType))
                            method.invoke(target, new Object[] {
                                new Boolean(DEFAULT_BOOLEAN)
                            });
                        else
                        if(paramType != null)
                            method.invoke(target, new Object[1]);
                    }
                    catch(Exception e)
                    {
        
                    }
            }
        }

        
    }

    public static final String getLookupProperties(Object source)
    {
        StringBuffer properties = new StringBuffer();
        Field fields[] = source.getClass().getDeclaredFields();
        int count = 0;
        for(int i = 0; i < fields.length; i++)
            if(fields[i].getName().endsWith("Text"))
            {
                if(count != 0)
                    properties.append(",");
                properties.append(fields[i].getName());
                count++;
            }

        
        return properties.toString();
    }
    
    private static int DEFAULT_INT;
    private static float DEFAULT_FLOAT;
    private static double DEFAULT_DOUBLE;
    private static short DEFAULT_SHORT;
    private static boolean DEFAULT_BOOLEAN;
    private static long DEFAULT_LONG;
}